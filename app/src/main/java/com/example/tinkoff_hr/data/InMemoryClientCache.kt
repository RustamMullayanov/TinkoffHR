package com.example.tinkoff_hr.data

import com.example.tinkoff_hr.domain.entities.worker.Worker
import com.example.tinkoff_hr.domain.entities.worker.WorkerStatus

// TODO remove this class when select/update worker by id will be fixed
object InMemoryClientCache {

    var client: Worker = Worker(
        2,
        "a.krysh@tinkoff.ru",
        "Андрей",
        "Крыш",
        "Константинович",
        "todo",
        1,
        2,
        "Мобильный разработчик",
        "SME Android Dev",
        WorkerStatus.ACTIVE
    )
}