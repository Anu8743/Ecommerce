package com.ziegler.Ecommerce.Repositories;

import com.ziegler.Ecommerce.Model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
