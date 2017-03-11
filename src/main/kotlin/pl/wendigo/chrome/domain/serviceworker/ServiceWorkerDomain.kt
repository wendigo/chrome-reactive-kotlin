package pl.wendigo.chrome.domain.serviceworker

/**
 * ServiceWorkerDomain represents remote debugger protocol domain.
 */
@pl.wendigo.chrome.ProtocolExperimental class ServiceWorkerDomain internal constructor(private val connection : pl.wendigo.chrome.DebuggerConnection) {

	/**
	 * 
	 */
	  fun enable() : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("ServiceWorker.enable", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * 
	 */
	  fun disable() : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("ServiceWorker.disable", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * 
	 */
	  fun unregister(input : UnregisterRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("ServiceWorker.unregister", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * 
	 */
	  fun updateRegistration(input : UpdateRegistrationRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("ServiceWorker.updateRegistration", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * 
	 */
	  fun startWorker(input : StartWorkerRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("ServiceWorker.startWorker", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * 
	 */
	  fun skipWaiting(input : SkipWaitingRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("ServiceWorker.skipWaiting", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * 
	 */
	  fun stopWorker(input : StopWorkerRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("ServiceWorker.stopWorker", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * 
	 */
	  fun inspectWorker(input : InspectWorkerRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("ServiceWorker.inspectWorker", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * 
	 */
	  fun setForceUpdateOnPageLoad(input : SetForceUpdateOnPageLoadRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("ServiceWorker.setForceUpdateOnPageLoad", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * 
	 */
	  fun deliverPushMessage(input : DeliverPushMessageRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("ServiceWorker.deliverPushMessage", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * 
	 */
	  fun dispatchSyncEvent(input : DispatchSyncEventRequest) : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("ServiceWorker.dispatchSyncEvent", input, pl.wendigo.chrome.ResponseFrame::class.java)
	}

  
  /**
   * 
   */
   fun onWorkerRegistrationUpdated() : io.reactivex.Flowable<WorkerRegistrationUpdatedEvent> {
      return connection.captureEvents("ServiceWorker.workerRegistrationUpdated", WorkerRegistrationUpdatedEvent::class.java)
   }

  /**
   * 
   */
   fun onWorkerVersionUpdated() : io.reactivex.Flowable<WorkerVersionUpdatedEvent> {
      return connection.captureEvents("ServiceWorker.workerVersionUpdated", WorkerVersionUpdatedEvent::class.java)
   }

  /**
   * 
   */
   fun onWorkerErrorReported() : io.reactivex.Flowable<WorkerErrorReportedEvent> {
      return connection.captureEvents("ServiceWorker.workerErrorReported", WorkerErrorReportedEvent::class.java)
   }
}





/**
 * Represents requestFrame parameters that can be used with ServiceWorker.unregister method call.
 *
 * 
 */
data class UnregisterRequest (
    /**
     * 
     */
    val scopeURL : String

)


/**
 * Represents requestFrame parameters that can be used with ServiceWorker.updateRegistration method call.
 *
 * 
 */
data class UpdateRegistrationRequest (
    /**
     * 
     */
    val scopeURL : String

)


/**
 * Represents requestFrame parameters that can be used with ServiceWorker.startWorker method call.
 *
 * 
 */
data class StartWorkerRequest (
    /**
     * 
     */
    val scopeURL : String

)


/**
 * Represents requestFrame parameters that can be used with ServiceWorker.skipWaiting method call.
 *
 * 
 */
data class SkipWaitingRequest (
    /**
     * 
     */
    val scopeURL : String

)


/**
 * Represents requestFrame parameters that can be used with ServiceWorker.stopWorker method call.
 *
 * 
 */
data class StopWorkerRequest (
    /**
     * 
     */
    val versionId : String

)


/**
 * Represents requestFrame parameters that can be used with ServiceWorker.inspectWorker method call.
 *
 * 
 */
data class InspectWorkerRequest (
    /**
     * 
     */
    val versionId : String

)


/**
 * Represents requestFrame parameters that can be used with ServiceWorker.setForceUpdateOnPageLoad method call.
 *
 * 
 */
data class SetForceUpdateOnPageLoadRequest (
    /**
     * 
     */
    val forceUpdateOnPageLoad : Boolean

)


/**
 * Represents requestFrame parameters that can be used with ServiceWorker.deliverPushMessage method call.
 *
 * 
 */
data class DeliverPushMessageRequest (
    /**
     * 
     */
    val origin : String,

    /**
     * 
     */
    val registrationId : String,

    /**
     * 
     */
    val data : String

)


/**
 * Represents requestFrame parameters that can be used with ServiceWorker.dispatchSyncEvent method call.
 *
 * 
 */
data class DispatchSyncEventRequest (
    /**
     * 
     */
    val origin : String,

    /**
     * 
     */
    val registrationId : String,

    /**
     * 
     */
    val tag : String,

    /**
     * 
     */
    val lastChance : Boolean

)



/**
 * Represents responseFrame from ServiceWorker. method call.
 *
 * 
 */
data class WorkerRegistrationUpdatedEvent(
  /**
   * 
   */
  val registrations : Array<ServiceWorkerRegistration>

) : pl.wendigo.chrome.DebuggerEvent(domain = "ServiceWorker", name = "workerRegistrationUpdated")

/**
 * Represents responseFrame from ServiceWorker. method call.
 *
 * 
 */
data class WorkerVersionUpdatedEvent(
  /**
   * 
   */
  val versions : Array<ServiceWorkerVersion>

) : pl.wendigo.chrome.DebuggerEvent(domain = "ServiceWorker", name = "workerVersionUpdated")

/**
 * Represents responseFrame from ServiceWorker. method call.
 *
 * 
 */
data class WorkerErrorReportedEvent(
  /**
   * 
   */
  val errorMessage : ServiceWorkerErrorMessage

) : pl.wendigo.chrome.DebuggerEvent(domain = "ServiceWorker", name = "workerErrorReported")

