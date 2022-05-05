package com.example.tinkoff_hr.ui.workers.worker_profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.example.tinkoff_hr.App
import com.example.tinkoff_hr.databinding.ActivityWorkerProfileBinding
import com.example.tinkoff_hr.domain.entities.worker.Worker
import com.example.tinkoff_hr.presentation.WorkerProfilePresenter
import com.example.tinkoff_hr.views.WorkerProfileView
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

class WorkerProfileActivity : MvpAppCompatActivity(), WorkerProfileView {

    @Inject
    lateinit var presenterProvider: Provider<WorkerProfilePresenter>

    private val workerProfilePresenter by moxyPresenter { presenterProvider.get() }

    private val binding: ActivityWorkerProfileBinding by lazy {
        ActivityWorkerProfileBinding.inflate(layoutInflater)
    }

    private val workerId: String by lazy { intent.getStringExtra(EXTRA_WORKER_ID)!! }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        workerProfilePresenter.onAppearing(workerId)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                this.finish()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun showWorkerInfo(worker: Worker) {
        with(binding) {
            fieldFullName.setText("${worker.surname} ${worker.name} ${worker.patronymic ?: ""}")
            fieldMail.setText(worker.email)
            fieldAbout.setText(worker.about)
            fieldFunction.setText(worker.function)
            fieldProject.setText(worker.project)
        }
        supportActionBar?.title = "${worker.surname} ${worker.name}"
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    companion object {

        private const val EXTRA_WORKER_ID = "extra_worker_id"

        fun createIntent(context: Context, workerId: String): Intent {
            return Intent(context, WorkerProfileActivity::class.java).apply {
                putExtra(EXTRA_WORKER_ID, workerId)
            }
        }
    }
}