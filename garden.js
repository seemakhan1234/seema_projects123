let carts = document.querySelectorAll('.kart');

let products = [ 
    {
        name: "Marshmallow Textured Vase with Gold Rim",
        tag: "marshmallowtexturedvasewithgoldrim",
        price: 1399,
        inCart: 0
    },
    {
        name: "Eadric Solid Tall Vase",
        tag: "eadricsolidtallvase",
        price: 899,
        inCart: 0
    },
    {
        name: "Galaxy Floral Embossed Tall Vase",
        tag: "galaxyfloralembossedtallvase",
        price: 1399,
        inCart: 0
    },
    {
        name: "Galaxy Tapered Ombre Vase",
        tag: "galaxytaperedombrevase",
        price: 1199,
        inCart: 0
    },
    {
        name: "Galaxy Epoxy Print Vase",
        tag: "galaxyepoxyprintvase",
        price: 899,
        inCart: 0
    },
    {
        name: "Brit Fara Ceramic Stripe Vase",
        tag: "britfaraceramicstripevase",
        price: 2759,
        inCart: 0
    },
    {
        name: "Splendid Honeycomb Patterned Vase",
        tag: "splendidhoneycombpatternedvase",
        price: 1399,
        inCart: 0
    },
    {
        name: "Moksha Colorblocked Vase",
        tag: "mokshacolorblockedvase",
        price: 1599,
        inCart: 0
    },
    {
        name: "Valencia Cup Saucer Shaped Planter",
        tag: "valenciacupsaucershapedplanter",
        price: 799,
        inCart: 0
    },
    {
        name: "Miraya Ayaka Metal Planter with Stand",
        tag: "mirayaayakametalplanterwithstand",
        price: 999,
        inCart: 0
    },
    {
        name: "Gardenia Artificial Bamboo Plant",
        tag: "gardeniaartificialbambooplant",
        price: 1399,
        inCart: 0
    },
    {
        name: "Valencia Hanging Planter",
        tag: "valenciahangingplanter",
        price: 499,
        inCart: 0
    },
    {
        name: "Valencia Solid Hanging Planter",
        tag: "valenciasolidhangingplanter",
        price: 699,
        inCart: 0
    },
    {
        name: "Colour Connect Embossed Flower Pot",
        tag: "colourconnectembossedflowerpot",
        price: 999,
        inCart: 0
    },
    {
        name: "Valencia Orchids in Ceramic Pot",
        tag: "valenciaorchidsinceramicpot",
        price: 1299,
        inCart: 0
    },
    {
        name: "Gardenia Orchid in Black Pot",
        tag: "gardeniaorchidinblackpot",
        price: 899,
        inCart: 0
    }
];

for(let i=0; i< carts.length; i++) {
    carts[i].addEventListener('click', () => {
        cartNumbers(products[i]);
        totalCost(products[i]);
    });
}

function onLoadCartNumbers() {
    let productNumbers = localStorage.getItem('cartNumbers');
    if( productNumbers ) {
        document.querySelector('.icons .meter').textContent = productNumbers;
    }
}

function cartNumbers(product, action) {
    let productNumbers = localStorage.getItem('cartNumbers');
    productNumbers = parseInt(productNumbers);

    let cartItems = localStorage.getItem('productsInCart');
    cartItems = JSON.parse(cartItems);

    if( action ) {
        localStorage.setItem("cartNumbers", productNumbers - 1);
        document.querySelector('.icons .meter').textContent = productNumbers - 1;
        console.log("action running");
    } else if( productNumbers ) {
        localStorage.setItem("cartNumbers", productNumbers + 1);
        document.querySelector('.icons .meter').textContent = productNumbers + 1;
    } else {
        localStorage.setItem("cartNumbers", 1);
        document.querySelector('.icons .meter').textContent = 1;
    }
    setItems(product);
}

function setItems(product) {
    let cartItems = localStorage.getItem('productsInCart');
    cartItems = JSON.parse(cartItems);

    if(cartItems != null) {
        let currentProduct = product.tag;
    
        if( cartItems[currentProduct] == undefined ) {
            cartItems = {
                ...cartItems,
                [currentProduct]: product
            }
        } 
        cartItems[currentProduct].inCart += 1;

    } else {
        product.inCart = 1;
        cartItems = { 
            [product.tag]: product
        };
    }

    localStorage.setItem('productsInCart', JSON.stringify(cartItems));
}

function totalCost( product, action ) {
    let cart = localStorage.getItem("totalCost");

    if( action) {
        cart = parseInt(cart);

        localStorage.setItem("totalCost", cart - product.price);
    } else if(cart != null) {
        
        cart = parseInt(cart);
        localStorage.setItem("totalCost", cart + product.price);
    
    } else {
        localStorage.setItem("totalCost", product.price);
    }
}

function displayCart() {
    let cartItems = localStorage.getItem('productsInCart');
    cartItems = JSON.parse(cartItems);

    let cart = localStorage.getItem("totalCost");
    cart = parseInt(cart);

    let productContainer = document.querySelector('.products');
    
    if( cartItems && productContainer ) {
        productContainer.innerHTML = '';
        Object.values(cartItems).map( (item, index) => {
            productContainer.innerHTML += 
            `<div class="product-title">
            <img src="./javascripts/cart_photos/${item.tag}.jpg" />
                <span class="name sm-hide">${item.name}</span>
                <ion-icon name="close-circle"></ion-icon>
            </div>
            <div class="price sm-hide">Rs ${item.price}.00</div>
            <div class="quantity">
                <ion-icon class="decrease " name="arrow-dropleft-circle"></ion-icon>
                    <span>${item.inCart}</span>
                <ion-icon class="increase" name="arrow-dropright-circle"></ion-icon>   
            </div>
            <div class="total">Rs ${item.inCart * item.price}.00</div>`;
        });

        productContainer.innerHTML += `
            <div class="basketTotalContainer">
                <h4 class="basketTotalTitle">Basket Total</h4>
                <h4 class="basketTotal">Rs ${cart}.00</h4>
            </div>`

        deleteButtons();
        manageQuantity();
    }
}

function manageQuantity() {
    let decreaseButtons = document.querySelectorAll('.decrease');
    let increaseButtons = document.querySelectorAll('.increase');
    let currentQuantity = 0;
    let currentProduct = '';
    let cartItems = localStorage.getItem('productsInCart');
    cartItems = JSON.parse(cartItems);

    for(let i=0; i < increaseButtons.length; i++) {
        decreaseButtons[i].addEventListener('click', () => {
            console.log(cartItems);
            currentQuantity = decreaseButtons[i].parentElement.querySelector('span').textContent;
            console.log(currentQuantity);
            currentProduct = decreaseButtons[i].parentElement.previousElementSibling.previousElementSibling.querySelector('span').textContent.toLocaleLowerCase().replace(/ /g,'').trim();
            console.log(currentProduct);

            if( cartItems[currentProduct].inCart > 1 ) {
                cartItems[currentProduct].inCart -= 1;
                cartNumbers(cartItems[currentProduct], "decrease");
                totalCost(cartItems[currentProduct], "decrease");
                localStorage.setItem('productsInCart', JSON.stringify(cartItems));
                displayCart();
            }
        });

        increaseButtons[i].addEventListener('click', () => {
            console.log(cartItems);
            currentQuantity = increaseButtons[i].parentElement.querySelector('span').textContent;
            console.log(currentQuantity);
            currentProduct = increaseButtons[i].parentElement.previousElementSibling.previousElementSibling.querySelector('span').textContent.toLocaleLowerCase().replace(/ /g,'').trim();
            console.log(currentProduct);

            cartItems[currentProduct].inCart += 1;
            cartNumbers(cartItems[currentProduct]);
            totalCost(cartItems[currentProduct]);
            localStorage.setItem('productsInCart', JSON.stringify(cartItems));
            displayCart();
        });
    }
}

function deleteButtons() {
    let deleteButtons = document.querySelectorAll('.product-title ion-icon');
    let productNumbers = localStorage.getItem('cartNumbers');
    let cartCost = localStorage.getItem("totalCost");
    let cartItems = localStorage.getItem('productsInCart');
    cartItems = JSON.parse(cartItems);
    let productName;
    console.log(cartItems);

    for(let i=0; i < deleteButtons.length; i++) {
        deleteButtons[i].addEventListener('click', () => {
            productName = deleteButtons[i].parentElement.textContent.toLocaleLowerCase().replace(/ /g,'').trim();
           
            localStorage.setItem('cartNumbers', productNumbers - cartItems[productName].inCart);
            localStorage.setItem('totalCost', cartCost - ( cartItems[productName].price * cartItems[productName].inCart));

            delete cartItems[productName];
            localStorage.setItem('productsInCart', JSON.stringify(cartItems));

            displayCart();
            onLoadCartNumbers();
        })
    }
}

onLoadCartNumbers();
displayCart();
