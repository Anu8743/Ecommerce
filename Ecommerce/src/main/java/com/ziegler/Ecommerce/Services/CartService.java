package com.ziegler.Ecommerce.Services;

import com.ziegler.Ecommerce.Model.CartItem;
import com.ziegler.Ecommerce.Model.Product;
import com.ziegler.Ecommerce.Repositories.CartItemRepository;
import com.ziegler.Ecommerce.Repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    private final CartItemRepository cartRepo;
    private final ProductRepository productRepo;

    public CartService(CartItemRepository cartRepo, ProductRepository productRepo) {
        this.cartRepo = cartRepo;
        this.productRepo = productRepo;
    }

    public CartItem addToCart(Long productId, int quantity) {
        Product product = productRepo.findById(productId).orElseThrow();
        CartItem item = new CartItem();
        item.setProduct(product);
        item.setQuantity(quantity);
        return cartRepo.save(item);
    }

    public List<CartItem> getCartItems() {
        return cartRepo.findAll();
    }

    public void removeFromCart(Long itemId) {
        cartRepo.deleteById(itemId);
    }

    public CartItem updateQuantity(Long itemId, int quantity) {
        CartItem item = cartRepo.findById(itemId).orElseThrow();
        item.setQuantity(quantity);
        return cartRepo.save(item);
    }

    public double getTotalCost() {
        return cartRepo.findAll().stream()
                .mapToDouble(i -> i.getProduct().getPrice() * i.getQuantity())
                .sum();
    }
}
