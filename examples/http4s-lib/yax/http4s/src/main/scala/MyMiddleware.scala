// http://http4s.org/v0.16/middleware/
// http://http4s.org/v0.17/middleware/

#+0.17
import fs2.interop.cats._
#-0.17

import org.http4s._

object MyMiddle {
  def addHeader(mResp: MaybeResponse, header: Header) =
    mResp match {
      case Status.Successful(resp) => resp.putHeaders(header)
      case resp => resp
    }

  def apply(service: HttpService, header: Header) =
    service.map(addHeader(_, header))
}
