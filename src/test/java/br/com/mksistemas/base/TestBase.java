package br.com.mksistemas.base;

public abstract class TestBase {

	protected abstract void setup();

	protected abstract void execute();

	protected void finalize() {}

	protected abstract void when();

	protected abstract void then();

	public void executeTest() {
		setup();
		try {
			when();
			execute();
			then();
		} finally {
			finalize();
		}
	}
}
