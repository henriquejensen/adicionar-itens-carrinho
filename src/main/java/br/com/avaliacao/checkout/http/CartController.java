package br.com.avaliacao.checkout.http;

import br.com.avaliacao.checkout.db.CartDBInMemory;
import br.com.avaliacao.checkout.model.Produto;
import br.com.avaliacao.checkout.model.AddCart;
import br.com.avaliacao.checkout.model.Cart;
import br.com.avaliacao.checkout.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartDBInMemory cartDB;

    @RequestMapping(value = "/adicionar", method = RequestMethod.POST)
    public void addToCart(@RequestBody AddCart add) {
    		        	
    	Produto p = new Produto();
        p.setCodigo(add.getCodeProduct());
        p.setNome(add.getNameProduct());
        p.setMarca(add.getBrand());
        p.setPreco(add.getPrice());

        CartItem item = new CartItem();
        item.setProduto(p);
        item.setQuantity(add.getQ());

        Cart cart = cartDB.findOne(add.getCartId());

        if (cart == null) {
            cart = new Cart();
            cart.setCartId(add.getCartId());
        } //ATENCAO: caso o carrinho ja exista, o fluxo atende?

        cart.getItems().add(item);
        cartDB.save(cart);
    }
    
    @RequestMapping("/{id}")
    public Cart listCart(@PathVariable String id) {
    	return cartDB.findOne(id);
    }


}

