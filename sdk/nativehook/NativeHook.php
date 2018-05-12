<?php
namespace nativehook;


class NativeHook{
    public function __construct(){}
    /**
    * @param string $event
    * @param callable $handler
    * Установить обработчик для события
    */
    public function on(string $event, callable $handler){}
    /**
    * @param string $event
    * Удалить обработчик для события
    */
    public function off(string $event){}
    /**
    * Начать слушать события
    */
    public function start(){}
    /**
    * Прекратить слушать события
    */
    public function stop(){}
}