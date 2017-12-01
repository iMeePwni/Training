package com.example.guofeng.training.model.service

import android.util.Log
import com.squareup.leakcanary.AnalysisResult
import com.squareup.leakcanary.DisplayLeakService
import com.squareup.leakcanary.HeapDump

class LeakService : DisplayLeakService() {

    override fun afterDefaultHandling(heapDump: HeapDump?, result: AnalysisResult, leakInfo: String?) {
        super.afterDefaultHandling(heapDump, result, leakInfo)
        if (!(!result.leakFound || result.excludedLeak)) {
            uploadHeapDump(heapDump, result, leakInfo)
        }
    }

    private fun uploadHeapDump(heapDump: HeapDump?, result: AnalysisResult, leakInfo: String?) {
        Log.d(javaClass.simpleName, "uploadHeapDump")
    }
}
