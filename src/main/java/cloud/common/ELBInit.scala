package cloud.common

import se.sics.kompics.Init
import instance.common.Block
import se.sics.kompics.address.Address
/**
 * @author Amir Moulavi
 * @date 2011-07-09
 *
 */
class ELBInit(val blocks:java.util.List[Block],
              val replicationDegree:Int,
              val self:Address) extends Init