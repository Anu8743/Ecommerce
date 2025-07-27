package com.ziegler.Ecommerce.Controllers;

import com.ziegler.Ecommerce.Model.CartItem;
import com.ziegler.Ecommerce.Services.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService service;

    public CartController(CartService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public CartItem addToCart(@RequestParam Long productId, @RequestParam int quantity) {
        return service.addToCart(productId, quantity);
    }

    @GetMapping
    public List<CartItem> viewCart() {
        return service.getCartItems();
    }

    @PutMapping("/update/{id}")
    public CartItem updateCartItem(@PathVariable Long id, @RequestParam int quantity) {
        return service.updateQuantity(id, quantity);
    }

    @DeleteMapping("/remove/{id}")
    public void removeCartItem(@PathVariable Long id) {
        service.removeFromCart(id);
    }

    @GetMapping("/total")
    public Map<String, Double> getTotal() {
        return Map.of("totalCost", service.getTotalCost());
    }
}