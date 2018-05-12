# jphp-nativehook-ext

NativeHook for jphp.

## Install
```
jppm add nativehook
```
## Examples
```php
use nativehook\NativeHook;
use nativehook\NativeMouseEvent;
use nativehook\NativeKeyEvent;
use nativehook\NativeMouseWheelEvent;

$hook = new NativeHook;
// mouseUp, mouseDown, mouseClick, mouseMove or mouseDragged
$hook->on('mouseDown', function(NativeMouseEvent $e){
    echo "Mouse pressed on {$e->x},{$e->y}\n";
});
// keyUp, keyDown or keyPress
$hook->on('keyUp', function(NativeKeyEvent $e){
    echo "Key {$e->key} is released\n";
});
$hook->on('mouseWheel', function(NativeMouseWheelEvent $e){
    echo "Mouse wheel\n";
});

$hook->start();
...
$hook->stop();
```
## Bundle for develnext
[download](https://github.com/jphp-group/jphp-nativehook-ext/releases/download/1.0.6/nativehook.dnbundle)
## API Documentation
[api-docs](api-docs/).
