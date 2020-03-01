package dollar.kimi.aop;

public class TargetService implements ITargetService {

	@Override
	public void printSomeThing() {
		System.out.println("This is TargetService");

	}

}
