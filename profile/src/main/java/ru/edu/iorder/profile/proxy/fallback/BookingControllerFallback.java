package ru.edu.iorder.profile.proxy.fallback;

import org.springframework.stereotype.Component;
import ru.edu.iorder.profile.proxy.BookingControllerProxy;

@Component
public class BookingControllerFallback implements BookingControllerProxy {
    @Override
    public String create() {
        return null;
    }
}
