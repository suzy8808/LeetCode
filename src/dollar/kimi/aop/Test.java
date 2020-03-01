package dollar.kimi.aop;

import java.lang.reflect.Proxy;

public class Test {
	public static void main(String[] args) {
		AroundMethodInvoke aroundMethodInvoke = new AroundMethodInvoke();
		aroundMethodInvoke.setObj(new TargetService());
		// 返回的对象是继承了Proxy 所以需要实现接口才能和Target产生联系
		ITargetService target = (ITargetService) Proxy.newProxyInstance(Test.class.getClassLoader(),
				new Class[] { ITargetService.class }, aroundMethodInvoke);
		target.printSomeThing();
	}
}
