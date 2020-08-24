package br.com.mksistemas.base.mapeamento;

public interface IMapper {
	public <T> T map(Object source, Class<T> dest);
	public void map(Object source, Object dest);
}
