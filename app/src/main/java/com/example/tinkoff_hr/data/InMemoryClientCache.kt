package com.example.tinkoff_hr.data

import com.example.tinkoff_hr.domain.entities.worker.Worker
import com.example.tinkoff_hr.domain.entities.worker.WorkerStatus

// TODO remove this class when select/update worker by id will be fixed
object InMemoryClientCache {

    var client: Worker = Worker(
        "2",
        "test2@tin.koff",
        "Андрей",
        "Крыш",
        "Константинович",
        "todo",
        "1",
        "2",
        "мобильный разработчик",
        "люблю Warface",
        WorkerStatus.ACTIVE
    )
}