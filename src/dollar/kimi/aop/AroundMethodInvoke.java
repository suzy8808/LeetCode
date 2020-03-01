package dollar.kimi.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AroundMethodInvoke implements InvocationHandler {

	private Object obj;

	public void setObj(Object object) {
		this.obj = object;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("This is before");
		Object returnObj = method.invoke(obj, args);
		System.out.println("This is after");
		return returnObj;
	}

}
