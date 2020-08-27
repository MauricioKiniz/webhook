package br.com.mksistemas.functional;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Trying<TFailure, TSuccess> {

	private TFailure failure;

	public TFailure getFailure() {
		return failure;
	}

	private TSuccess success;

	public TSuccess getSuccess() {
		return success;
	}

	private boolean isFailure;

	public boolean isFailure() {
		return isFailure;
	}

	private boolean isSuccess;

	public boolean isSuccess() {
		return !isFailure;
	}

	public Optional<TFailure> getOptionalFailure() {
		return isFailure ? Optional.of(getFailure()) : Optional.empty();
	}

	public Optional<TSuccess> getOptionalSuccess() {
		return isSuccess ? Optional.of(success) : Optional.empty();
	}

	public Trying(TFailure failure, TSuccess success) {
		if (failure != null) {
			isFailure = true;
			this.failure = failure;
			this.success = null;
			return;
		}
		isSuccess = true;
		this.failure = null;
		this.success = success;
	}

	public <TResult> TResult match(Function<TFailure, TResult> failureFunction,
			Function<TSuccess, TResult> successFunction) {
		return isFailure ? failureFunction.apply(getFailure()) : successFunction.apply(success);
	}

	public Trying<TFailure, TSuccess> bind(Function<TSuccess, Trying<TFailure, TSuccess>> func) {
		return isSuccess ? func.apply(success) : this;
	}

	public <TData> Trying<TFailure, TSuccess> bind(BiFunction<TSuccess, TData , Trying<TFailure, TSuccess>> func, TData data) {
		return isSuccess ? func.apply(success, data) : this;
	}
	
	public Trying<TFailure, TSuccess> onException(Function<TSuccess, Trying<TFailure, TSuccess>> func,
			BiFunction<TSuccess, Throwable, Trying<TFailure, TSuccess>> funcException) {
		try {
			return bind(func);
		} catch (Exception e) {
			return funcException.apply(success, e);
		}
	}

	public <NewTSuccess> Trying<TFailure, NewTSuccess> map(Function<TSuccess, Trying<TFailure, NewTSuccess>> func) {
		return isSuccess ? func.apply(success) : Trying.createFailure(failure);
	}

	public static <TFailure, TSuccess> Trying<TFailure, TSuccess> createFailure(TFailure failure) {
		return new Trying<TFailure, TSuccess>(failure, null);
	}

	public static <TFailure, TSuccess> Trying<TFailure, TSuccess> createSuccess(TSuccess success) {
		return new Trying<TFailure, TSuccess>(null, success);
	}
}
