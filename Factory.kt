enum class Destination {
    Belarus, USA, Russia, Germany
}

object DeliveryFactory {

    fun create(destination: Destination): Delivery {
        return when (destination) {
            Destination.Belarus -> CarDeliveryImpl("1", 10, 10)
            Destination.USA -> WaterDeliveryImpl("2", 20, 20, WaterDelivery.WaterDeliveryType.Sea)
            Destination.Russia -> TrainDeliveryImpl("2", 30, 30, 10, false)
            Destination.Germany -> AirDeliveryImpl(
                    "4",
                    40,
                    40,
                    AirDelivery.Type.CrossCity,
                    AirDelivery.Transport.Cargo
            )
        }
    }
}

interface Delivery {

    val companyName: String

    val maxCapacity: Int

    val maxDimension: Int

    fun doDelivery()
}

interface WaterDelivery : Delivery {
    enum class WaterDeliveryType {
        River, Sea
    }

    val waterDeliveryType: WaterDeliveryType
}

interface TrainDelivery : Delivery {
    val trackSize: Int

    val isHaveBallast: Boolean
}

interface AirDelivery : Delivery {
    enum class Type {
        InCity, CrossCity, Internation
    }

    enum class Transport {
        Civilian, Cargo
    }

    val type: Type

    val transport: Transport
}

interface CarDelivery : Delivery

class AirDeliveryImpl(
        override val companyName: String,
        override val maxCapacity: Int,
        override val maxDimension: Int,
        override val type: AirDelivery.Type,
        override val transport: AirDelivery.Transport
) : AirDelivery {
    override fun doDelivery() {
        TODO("Not yet implemented")
    }
}

class TrainDeliveryImpl(
        override val companyName: String,
        override val maxCapacity: Int,
        override val maxDimension: Int,
        override val trackSize: Int,
        override val isHaveBallast: Boolean
) : TrainDelivery {
    override fun doDelivery() {
        TODO("Not yet implemented")
    }
}

class WaterDeliveryImpl(override val companyName: String, override val maxCapacity: Int, override val maxDimension: Int, override val waterDeliveryType: WaterDelivery.WaterDeliveryType) : WaterDelivery {
    override fun doDelivery() {
        TODO("Not yet implemented")
    }

}

class CarDeliveryImpl(override val companyName: String, override val maxCapacity: Int, override val maxDimension: Int) : CarDelivery {
    override fun doDelivery() {
        TODO("Not yet implemented")
    }
}


