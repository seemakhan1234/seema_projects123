let carts = document.querySelectorAll('.kart');

let products = [ 
    {
        name: "Splendid Barend Deer Figurine",
        tag: "splendidbarenddeerfigurine",
        price: 1999,
        inCart: 0
    },
    {
        name: "Corsica Stone Encrusted Peacock Figurine",
        tag: "corsicastoneencrustedpeacockfigurine",
        price: 1279,
        inCart: 0
    },
    {
        name: "Galaxy Man with Stone Decor Figurine",
        tag: "galaxymanwithstonedecorfigurine",
        price: 1799,
        inCart: 0
    },
    {
        name: "Galaxy Abstract Swan Figurine",
        tag: "galaxyabstractswanfigurine",
        price: 2199,
        inCart: 0
    },
    {
        name: "Corsica Embellished Buddha Figurine",
        tag: "corsicaembellishedbuddhafigurine",
        price: 899,
        inCart: 0
    },
    {
        name: "Moksha Hanging Deco Bird In Ring",
        tag: "mokshahangingdecobirdinring",
        price: 1199,
        inCart: 0
    },
    {
        name: "Cosmos Angel Turtle Figurine",
        tag: "cosmosangelturtlefigurine",
        price: 399,
        inCart: 0
    },
    {
        name: "Jaguar Horses On Stand Figurine",
        tag: "jaguarhorsesonstandfigurine",
        price: 2099,
        inCart: 0
    },
    {
        name: "Derby Solid Floor Lamp",
        tag: "derbysolidfloorlamp",
        price: 1599,
        inCart: 0
    },
    {
        name: "Metal Touch Table Lamp",
        tag: "metaltouchtablelamp",
        price: 1999,
        inCart: 0
    },
    {
        name: "Quinn Textured Table Lamp",
        tag: "quinntexturedtablelamp",
        price: 999,
        inCart: 0
    },
    {
        name: "Serena Twig Light",
        tag: "serenatwiglight",
        price: 699,
        inCart: 0
    },
    {
        name: "Tranquil Ceramic Buddha Table Lamp",
        tag: "tranquilceramicbuddhatablelamp",
        price: 999,
        inCart: 0
    },
    {
        name: "Mariana Mosaiced Table Lamp",
        tag: "marianamosaicedtablelamp",
        price: 799,
        inCart: 0
    },
    {
        name: "Beam Riley Printed Floral Lamp",
        tag: "beamrileyprintedflorallamp",
        price: 799,
        inCart: 0
    },
    {
        name: "Beam Riley Floral Print Lamp",
        tag: "beamrileyfloralprintlamp",
        price: 799,
        inCart: 0
    },
    {
        name: "Eternity Tortoise Figurine Decor Bowl",
        tag: "eternitytortoisefigurinedecorbowl",
        price: 1799,
        inCart: 0
    },
    {
        name: "Splendid Textured Decorative Leaf Platter",
        tag: "splendidtextureddecorativeleafplatter",
        price: 1199,
        inCart: 0
    },
    {
        name: "Splendid Baroque Pattern Platter",
        tag: "splendidbaroquepatternplatter",
        price: 1199,
        inCart: 0
    },
    {
        name: "Splendid Wade Bird Design Platter",
        tag: "splendidwadebirddesignplatter",
        price: 899,
        inCart: 0
    },
    {
        name: "Marshmallow Textured Decor Jar",
        tag: "marshmallowtextureddecorjar",
        price: 999,
        inCart: 0
    },
    {
        name: "Eternity Cotton Ball Round Table Accent",
        tag: "eternitycottonballroundtableaccent",
        price: 999,
        inCart: 0
    },
    {
        name: "Eternity Tic Tac Toe Table Accent",
        tag: "eternitytictactoetableaccent",
        price: 1999,
        inCart: 0
    },
    {
        name: "Eternity Bird Accent Decor Bowl",
        tag: "eternitybirdaccentdecorbowl",
        price: 3499,
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
