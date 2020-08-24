<?php


namespace nativehook\mouse;


use nativehook\NativeInputEvent;

class NativeMouseEvent extends NativeInputEvent{
    const NATIVE_MOUSE_CLICKED = 2500;
    const NATIVE_MOUSE_PRESSED = 2501;
    const NATIVE_MOUSE_RELEASED = 2502;
    const NATIVE_MOUSE_MOVED = 2503;
    const NATIVE_MOUSE_DRAGGED = 2504;
    const NATIVE_MOUSE_WHEEL = 2505;

    /**
     * @var int
     */
    public $button;
    /**
     * @var int
     */
    public $clickCount;
    /**
     * @var int
     */
    public $x;
    /**
     * @var int
     */
    public $y;

    public function __construct(int $id, int $when, int $modifiers, int $x, int $y, int $clickCount, int $button = 0){

    }

    public function isPrimaryButtonDown(): bool{}
    public function isSecondaryButtonDown(): bool{}
    public function isMiddleButtonDown(): bool{}
}