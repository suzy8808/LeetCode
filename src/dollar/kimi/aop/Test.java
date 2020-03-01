package dollar.kimi.aop;

import java.lang.reflect.Proxy;

public class Test {
	public static void main(String[] args) {
		AroundMethodInvoke aroundMethodInvoke = new AroundMethodInvoke();
		aroundMethodInvoke.setObj(new TargetService());
		// ���صĶ����Ǽ̳���Proxy ������Ҫʵ�ֽӿڲ��ܺ�Target������ϵ
		ITargetService target = (ITargetService) Proxy.newProxyInstance(Test.class.getClassLoader(),
				new Class[] { ITargetService.class }, aroundMethodInvoke);
		target.printSomeThing();
	}
}
