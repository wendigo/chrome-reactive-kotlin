package pl.wendigo.chrome.domain.serviceworker

/**
 * ServiceWorkerDomain represents remote debugger protocol domain.
 */
@pl.wendigo.chrome.Experimental class ServiceWorkerDomain internal constructor(private val connectionRemote : pl.wendigo.chrome.DebuggerProtocol) {

	/**
	 * 
	 */
	 fun enable() : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("ServiceWorker.enable", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
	}

    /**
     * 
    */
     fun enableTimed() : io.reactivex.Single<io.reactivex.schedulers.Timed<pl.wendigo.chrome.ResponseFrame>> {
        return connectionRemote.runAndCaptureResponse("ServiceWorker.enable", null, pl.wendigo.chrome.ResponseFrame::class.java)
    }

	/**
	 * 
	 */
	 fun disable() : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("ServiceWorker.disable", null, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
	}

    /**
     * 
    */
     fun disableTimed() : io.reactivex.Single<io.reactivex.schedulers.Timed<pl.wendigo.chrome.ResponseFrame>> {
        return connectionRemote.runAndCaptureResponse("ServiceWorker.disable", null, pl.wendigo.chrome.ResponseFrame::class.java)
    }

	/**
	 * 
	 */
	 fun unregister(input : UnregisterRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("ServiceWorker.unregister", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
	}

    /**
     * 
    */
     fun unregisterTimed(input : UnregisterRequest) : io.reactivex.Single<io.reactivex.schedulers.Timed<pl.wendigo.chrome.ResponseFrame>> {
        return connectionRemote.runAndCaptureResponse("ServiceWorker.unregister", input, pl.wendigo.chrome.ResponseFrame::class.java)
    }

	/**
	 * 
	 */
	 fun updateRegistration(input : UpdateRegistrationRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("ServiceWorker.updateRegistration", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
	}

    /**
     * 
    */
     fun updateRegistrationTimed(input : UpdateRegistrationRequest) : io.reactivex.Single<io.reactivex.schedulers.Timed<pl.wendigo.chrome.ResponseFrame>> {
        return connectionRemote.runAndCaptureResponse("ServiceWorker.updateRegistration", input, pl.wendigo.chrome.ResponseFrame::class.java)
    }

	/**
	 * 
	 */
	 fun startWorker(input : StartWorkerRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("ServiceWorker.startWorker", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
	}

    /**
     * 
    */
     fun startWorkerTimed(input : StartWorkerRequest) : io.reactivex.Single<io.reactivex.schedulers.Timed<pl.wendigo.chrome.ResponseFrame>> {
        return connectionRemote.runAndCaptureResponse("ServiceWorker.startWorker", input, pl.wendigo.chrome.ResponseFrame::class.java)
    }

	/**
	 * 
	 */
	 fun skipWaiting(input : SkipWaitingRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("ServiceWorker.skipWaiting", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
	}

    /**
     * 
    */
     fun skipWaitingTimed(input : SkipWaitingRequest) : io.reactivex.Single<io.reactivex.schedulers.Timed<pl.wendigo.chrome.ResponseFrame>> {
        return connectionRemote.runAndCaptureResponse("ServiceWorker.skipWaiting", input, pl.wendigo.chrome.ResponseFrame::class.java)
    }

	/**
	 * 
	 */
	 fun stopWorker(input : StopWorkerRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("ServiceWorker.stopWorker", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
	}

    /**
     * 
    */
     fun stopWorkerTimed(input : StopWorkerRequest) : io.reactivex.Single<io.reactivex.schedulers.Timed<pl.wendigo.chrome.ResponseFrame>> {
        return connectionRemote.runAndCaptureResponse("ServiceWorker.stopWorker", input, pl.wendigo.chrome.ResponseFrame::class.java)
    }

	/**
	 * 
	 */
	 fun inspectWorker(input : InspectWorkerRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("ServiceWorker.inspectWorker", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
	}

    /**
     * 
    */
     fun inspectWorkerTimed(input : InspectWorkerRequest) : io.reactivex.Single<io.reactivex.schedulers.Timed<pl.wendigo.chrome.ResponseFrame>> {
        return connectionRemote.runAndCaptureResponse("ServiceWorker.inspectWorker", input, pl.wendigo.chrome.ResponseFrame::class.java)
    }

	/**
	 * 
	 */
	 fun setForceUpdateOnPageLoad(input : SetForceUpdateOnPageLoadRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("ServiceWorker.setForceUpdateOnPageLoad", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
	}

    /**
     * 
    */
     fun setForceUpdateOnPageLoadTimed(input : SetForceUpdateOnPageLoadRequest) : io.reactivex.Single<io.reactivex.schedulers.Timed<pl.wendigo.chrome.ResponseFrame>> {
        return connectionRemote.runAndCaptureResponse("ServiceWorker.setForceUpdateOnPageLoad", input, pl.wendigo.chrome.ResponseFrame::class.java)
    }

	/**
	 * 
	 */
	 fun deliverPushMessage(input : DeliverPushMessageRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("ServiceWorker.deliverPushMessage", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
	}

    /**
     * 
    */
     fun deliverPushMessageTimed(input : DeliverPushMessageRequest) : io.reactivex.Single<io.reactivex.schedulers.Timed<pl.wendigo.chrome.ResponseFrame>> {
        return connectionRemote.runAndCaptureResponse("ServiceWorker.deliverPushMessage", input, pl.wendigo.chrome.ResponseFrame::class.java)
    }

	/**
	 * 
	 */
	 fun dispatchSyncEvent(input : DispatchSyncEventRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("ServiceWorker.dispatchSyncEvent", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
	}

    /**
     * 
    */
     fun dispatchSyncEventTimed(input : DispatchSyncEventRequest) : io.reactivex.Single<io.reactivex.schedulers.Timed<pl.wendigo.chrome.ResponseFrame>> {
        return connectionRemote.runAndCaptureResponse("ServiceWorker.dispatchSyncEvent", input, pl.wendigo.chrome.ResponseFrame::class.java)
    }

  
    /**
     * Returns observable capturing all ServiceWorker.workerRegistrationUpdated events.
     */
    fun workerRegistrationUpdated() : io.reactivex.Flowable<WorkerRegistrationUpdatedEvent> {
        return workerRegistrationUpdatedTimed().map {
            it.value()
        }
    }

    /**
     * Returns observable capturing all ServiceWorker.workerRegistrationUpdated events.
     */
     fun workerRegistrationUpdatedTimed() : io.reactivex.Flowable<io.reactivex.schedulers.Timed<WorkerRegistrationUpdatedEvent>> {
        return connectionRemote.captureEvents("ServiceWorker.workerRegistrationUpdated", WorkerRegistrationUpdatedEvent::class.java)
     }

    /**
     * Returns observable capturing all ServiceWorker.workerVersionUpdated events.
     */
    fun workerVersionUpdated() : io.reactivex.Flowable<WorkerVersionUpdatedEvent> {
        return workerVersionUpdatedTimed().map {
            it.value()
        }
    }

    /**
     * Returns observable capturing all ServiceWorker.workerVersionUpdated events.
     */
     fun workerVersionUpdatedTimed() : io.reactivex.Flowable<io.reactivex.schedulers.Timed<WorkerVersionUpdatedEvent>> {
        return connectionRemote.captureEvents("ServiceWorker.workerVersionUpdated", WorkerVersionUpdatedEvent::class.java)
     }

    /**
     * Returns observable capturing all ServiceWorker.workerErrorReported events.
     */
    fun workerErrorReported() : io.reactivex.Flowable<WorkerErrorReportedEvent> {
        return workerErrorReportedTimed().map {
            it.value()
        }
    }

    /**
     * Returns observable capturing all ServiceWorker.workerErrorReported events.
     */
     fun workerErrorReportedTimed() : io.reactivex.Flowable<io.reactivex.schedulers.Timed<WorkerErrorReportedEvent>> {
        return connectionRemote.captureEvents("ServiceWorker.workerErrorReported", WorkerErrorReportedEvent::class.java)
     }

    /**
     * Returns flowable capturing all ServiceWorker domains events.
     */
    fun events() : io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "ServiceWorker"
        }
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

) : pl.wendigo.chrome.ProtocolEvent(domain = "ServiceWorker", name = "workerRegistrationUpdated")

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

) : pl.wendigo.chrome.ProtocolEvent(domain = "ServiceWorker", name = "workerVersionUpdated")

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

) : pl.wendigo.chrome.ProtocolEvent(domain = "ServiceWorker", name = "workerErrorReported")

