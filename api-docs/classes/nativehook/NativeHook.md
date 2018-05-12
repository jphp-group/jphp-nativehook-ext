# NativeHook

- **class** `NativeHook` (`nativehook\NativeHook`)
- **source** `nativehook/NativeHook.php`

---

#### Methods

- `->`[`__construct()`](#method-__construct)
- `->`[`on()`](#method-on)
- `->`[`off()`](#method-off)
- `->`[`start()`](#method-start) - _Начать слушать события_
- `->`[`stop()`](#method-stop) - _Прекратить слушать события_

---
# Methods

<a name="method-__construct"></a>

### __construct()
```php
__construct(): void
```

---

<a name="method-on"></a>

### on()
```php
on(string $event, callable $handler): void
```

---

<a name="method-off"></a>

### off()
```php
off(string $event): void
```

---

<a name="method-start"></a>

### start()
```php
start(): void
```
Начать слушать события

---

<a name="method-stop"></a>

### stop()
```php
stop(): void
```
Прекратить слушать события