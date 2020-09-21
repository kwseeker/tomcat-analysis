package top.kwseeker.component.lifecycle;

/**
 * Tomcat所有组件都实现了Lifecycle接口
 */
public class Container {
    protected LifecycleSupport lifecycle = new LifecycleSupport();
}
