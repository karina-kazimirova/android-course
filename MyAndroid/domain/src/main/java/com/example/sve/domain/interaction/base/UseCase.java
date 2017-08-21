package com.example.sve.domain.interaction.base;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Sve on 11.08.2017.
 */
// Параметризованный класс
public abstract class UseCase<InParam, OutParam> {


    private Disposable disposable;


    // все классы реализуют этот абстрактный метод в зависимости от данных
    protected abstract Observable<OutParam> buildUseCase(InParam param);

    // все ккейсы выолняются по вызову этой функции, подаем входящий параметр и подаем исхдящее значение Disposable

    public void execute(InParam param, DisposableObserver<OutParam> disposableObserver){
       disposable =  buildUseCase(param)// создаст Observable но не запустит его, пока не найдет подписчика
               .subscribeOn(Schedulers.newThread())//где будет обработан объект - в главном потоке
               .observeOn(AndroidSchedulers.mainThread())// куда прийдет ответ, где выполнить ответ
               .subscribeWith(disposableObserver); // выполнится только когда к нему кто-нибудь подпишется
    }


    // отпиываемся в нужном месет чтобы не было утечки данных
    public void dispose(){
        if(!disposable.isDisposed()){
            disposable.dispose();
        }

    }


}
