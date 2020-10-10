# aggregate-core
1. DataRecord
1.1 Добавить валидицию на setValue в оба метода.
1.2 Сделать проверки на границы индексов для тайбл формата.
1.3 Сделать проверку на вхождение имени филда в тайблформат.
1.4 Equals HashCode, clone in DataRecord.
2.DataTable
2.1 Implement interface.
2.2 Equals HashCode, clone in DataTable.
2.3 Implement tests in DataTableTest.
3.3 Implement StubContext
4.1 Зафиксить ворнинги по дженерикам в проекте на ваше усмотрение
4.2 Написать коллекцию MultiMap (put, remove,...).
4.3 Fix generics in LimitsValidator and FieldFormatFactory. 

5.1 Сделать потокобезопасную BlockingQueue.
5.1.1 Возможность задавать размер очереди.
5.1.2 Producers должны ждать если очередь переполнена
5.1.3 Consumers должны ждать если очередь пуста.
5.1.4 Потокобезопасная работа с очередью.
5.1.5 Использовать ThreadPool для реализации консьмеров и продьюсеров.