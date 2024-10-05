class TV(val brand: String = "no name",val model: String = "no model", val diagonal: Float = 0f) {
    var on: Boolean = true
        private set
    var volume = 30
        private set

    private var currentChannel = Channel("no channel")
    private var channelList = listOf<Channel>()

    init {
        println("Настройка телевизора ${this.brand} ${this.model} с диагональю ${this.diagonal} и поиск каналов")
        channelList = Channels.getRandomChannels()
        println("Найденно каналов : ${channelList.size} ")
    }

    fun enableOrDisable() {
        if (!on) println("Включение телевизора")
        else println("Выключение телевизора")
        on = !on
    }

    fun volUp(vol: Int) {
        println("Увеличение текушей громкости ${this.volume} на $vol")
        if (vol > 0 && volume < maxVolume) {
            volume = if (volume + vol <= maxVolume) volume + vol else maxVolume
        }
        println("Уровень громкости ${this.volume}")
    }

    fun volDown(vol: Int) {
        println("Уменьшение текушей громкости ${this.volume} на $vol")
        if (vol > 0 && volume > 0) {
            volume = if (volume - vol >= 0) volume - vol else 0
        }
        println("Уровень громкости ${this.volume}")
    }

    fun switchChannel(index: Int) {
        if (!on) enableOrDisable()
        println("Переключение канала на $index")
        currentChannel = channelList.getOrElse(index) { Channel("не найден") }
        println("Текуший канал ${currentChannel.name}")

    }

    fun channelUp() {
        if (!on) enableOrDisable()
        else {
            println("Переключение канала вверх по списку")
            currentChannel = if (channelList.last() != currentChannel) {
                channelList[channelList.indexOf(currentChannel) + 1]
            } else {
                channelList.first()
            }
            println(currentChannel.name)
        }

    }

    fun channelDown() {
        if (!on) enableOrDisable()
        else {
            println("Переключение канала вниз по списку")
            currentChannel = if (channelList.first() != currentChannel) {
                channelList[channelList.indexOf(currentChannel) - 1]
            } else {
                channelList.last()
            }
            println(currentChannel.name)
        }
    }

    fun listAllChannel() {
        println("Список доступных каналов :")
        channelList.forEachIndexed { index, element -> println("$index - ${element.name}\n\t${element.description}") }
    }

    companion object {
        const val maxVolume = 100
    }
}