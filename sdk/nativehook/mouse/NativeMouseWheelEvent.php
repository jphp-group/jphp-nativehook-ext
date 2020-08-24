<?php


namespace nativehook\mouse;


class NativeMouseWheelEvent extends NativeMouseEvent{
    const WHEEL_BLOCK_SCROLL = 2;
    const WHEEL_UNIT_SCROLL = 1;

    /**
     * @var int
     */
    public $scrollAmount;
    /**
     * @var int
     */
    public $scrollType;
    /**
     * @var int
     */
    public $wheelRotation;

    public function __construct(int $id, int $when, int $modifiers, int $x, int $y, int $clickCount, int $scrollType, int $scrollAmount, int $wheelRotation){

    }
}