package ru.iipokoiiehko.main_core_api

abstract class Mapper<From, To> {

    abstract fun map(source: From): To

    fun mapList(sourceList: List<From>): List<To> = sourceList.map { map(it) }
}