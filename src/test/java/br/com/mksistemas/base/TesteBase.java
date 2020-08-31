package br.com.mksistemas.base;

import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public abstract class TesteBase {
	protected abstract void executar();

	public void executarTeste(Consumer<? super TesteBase> quando, Consumer<? super TesteBase> entao) {
		quando.accept(this);
		executar();
		entao.accept(this);
	}
	
	public <TData> void executarTeste(TData[] elementos, BiConsumer<? super TesteBase,TData> quando, BiConsumer<? super TesteBase, TData> entao) {
		Arrays.stream(elementos).forEach((item) -> 
		{
			quando.accept(this, item);
			executar();
			entao.accept(this, item);
		});
	}

	
}
