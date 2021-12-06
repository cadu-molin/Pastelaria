package br.com.pastelaria.compartilhado;

import java.io.Serializable;

public interface GenericCRUD <T, PK extends Serializable>{
	PK create(T newInstance);

    T read(PK id);

    void update(T transientObject);

    void delete(T persistentObject);
}
