package dev.serhat.bookshop.service;

import dev.serhat.bookshop.exception.DataNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;


/*
Bu generic soyut sınıf servislere temel crud işlemleri için methotlar sağlamaktadır.
Bu sayede her servis için ortak olan metotdları tekrar tekrar yazmak gerekmemektedir.
 */
public abstract class BaseService<T,ID>{

    private final JpaRepository<T,ID> repository;

    protected BaseService(JpaRepository<T,ID> repository) {
        this.repository = repository;
    }

    public T findById(ID id){
        return repository.findById(id).orElseThrow(()-> new DataNotFoundException("Şu id'ye sahip veri bulunamadı: "+id ));
    }

    public T create(T t){
        return repository.save(t);
    }

    public T update(T t){
        return repository.save(t);
    }
}
