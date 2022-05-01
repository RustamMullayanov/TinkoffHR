package com.example.tinkoff_hr.domain.factories

import com.example.tinkoff_hr.data.dto.toListItem
import com.example.tinkoff_hr.domain.entities.worker.Worker
import com.example.tinkoff_hr.domain.entities.worker.WorkerItem
import javax.inject.Inject

class DataItemFactory @Inject constructor() {

    companion object {
        fun createWorkerItems(workers: List<Worker>): List<WorkerItem> {
            return workers.map { worker -> worker.toListItem() }
        }
    }
}