#### 微信小程序模板消息推送框架
1. 支持基于时间窗口,时间间隔,formId库存的推送限制制定
2. 支持推送超限后的重试

##### usage
1. 实现AppletRepository
2. 实现TemplateMessageItemRepository
3. 实现HttpPoster
4. 实现PushRecorder

###### config
```$xslt
@Configuration
public class TemplatePushConfig {

    private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();
    @Autowired
    private AppletRepository appletRepository;
    @Autowired
    private HttpPoster httpPoster;
    @Autowired
    private PushRecorder pushRecorder;
    @Autowired
    private TemplateMessageItemRepository templateMessageItemRepository;

    @Bean
    public TemplatePusher templatePusher() {
        TemplatePusherBuilder pusherBuilder = new StandardTemplatePusherBuilder()
                .withAppletRepository(appletRepository)
                .withFormIdProvider(new StandardFormIdProvider())
                .withHttpPoster(httpPoster)
                .withPushRecorder(pushRecorder)
                .withExecutorService(EXECUTOR_SERVICE)
                .withTemplateMessageItemRepository(templateMessageItemRepository);
        pusherBuilder.addPushRuleExecutor(new TimeWindowPushRuleExecutor()
                .withRule(TimeWindowPushRule.ofGlobal().addTimeWindow(1, TimeUnit.MINUTES, 1)
                        .addTimeWindow(2, TimeUnit.HOURS, 10))
                .withRule(TimeWindowPushRule.ofBusiness("bus1").addTimeWindow(12, TimeUnit.HOURS, 10)));
        pusherBuilder.addPushRuleExecutor(new TimeGapPushRuleExecutor()
                .withRule(TimeGapPushRule.ofBusiness("bus1", true, 12, TimeUnit.SECONDS)));
        pusherBuilder.addPushRuleExecutor(new FormIdStockPushRuleExecutor()
                .withRule(FormIdStockPushRule.ofGlobal(3)));
        return pusherBuilder.build();
    }
}
```

###### service
```$xslt
@Service
public class Service {

    @Autowired
    private TemplatePusher templatePusher;

    @PostConstruct
    private void init() {
        templatePusher.onInit();
    }
 
    public void push() {
        templatePusher.push(new TemplateMessage(), "bus1", false);
    }
    
    public void saveFormId(String openId, String formId) {
        templatePusher.saveFormId(openId, formId, System.currentTimeMillis());
    }
}
```
