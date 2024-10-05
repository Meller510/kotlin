sealed class FireType {
    object SingleShot : FireType()
    data class FiringBurst(var queueSize: Int) : FireType()
}