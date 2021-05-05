package ru.edu.iorder.profile.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.edu.iorder.profile.proxy.fallback.BookingControllerFallback;

@FeignClient(name = "booking", fallback = BookingControllerFallback.class)
public interface BookingControllerProxy {
    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/booking/")
    public String create();
}
