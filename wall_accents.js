let carts = document.querySelectorAll('.kart');

let products = [ 
    {
        name: "Corsica Solid Circular Wall Clock",
        tag: "corsicasolidcircularwallclock",
        price: 719,
        inCart: 0
    },
    {
        name: "Estelle Telsa Contemporary Wall Clock",
        tag: "estelletelsacontemporarywallclock",
        price: 449,
        inCart: 0
    },
    {
        name: "Casablanca Coral Table Clock",
        tag: "casablancacoraltableclock",
        price: 1299,
        inCart: 0
    },
    {
        name: "Casablanca Station Wall Clock",
        tag: "casablancastationwallclock",
        price: 1199,
        inCart: 0
    },
    {
        name: "Estelle Telsa Contemporary Wall Clock 2",
        tag: "estelletelsacontemporarywallclock2",
        price: 449,
        inCart: 0
    },
    {
        name: "Casablanca Solid Wall Clock",
        tag: "casablancasolidwallclock",
        price: 999,
        inCart: 0
    },
    {
        name: "Eternity Globe Clock",
        tag: "eternityglobeclock",
        price: 1299,
        inCart: 0
    },
    {
        name: "Estelle Telsa Contemporary Wall Clock 3",
        tag: "estelletelsacontemporarywallclock3",
        price: 449,
        inCart: 0
    },
    {
        name: "Artistry Molly Cycle House Picture Frame",
        tag: "artistrymollycyclehousepictureframe",
        price: 4999,
        inCart: 0
    },
    {
        name: "Samara Multi Floral Leaf Wall Art",
        tag: "samaramultifloralleafwallart",
        price: 2599,
        inCart: 0
    },
    {
        name: "Samara Branched Circle Wall Decor",
        tag: "samarabranchedcirclewalldecor",
        price: 2999,
        inCart: 0
    },
    {
        name: "Athena Wall Mounted Decorative Cage",
        tag: "athenawallmounteddecorativecage",
        price: 1799,
        inCart: 0
    },
    {
        name: "Corsica Building Picture Frame",
        tag: "corsicabuildingpictureframe",
        price: 899,
        inCart: 0
    },
    {
        name: "Corsica Floral Pot Picture Frame",
        tag: "corsicafloralpotpictureframe",
        price: 899,
        inCart: 0
    },
    {
        name: "Artistry Eilat Nature Picture Frame",
        tag: "artistryeilatnaturepictureframe",
        price: 3999,
        inCart: 0
    },
    {
        name: "Artistry Haifa Macaw Bird Picture Frame",
        tag: "artistryhaifamacawbirdpictureframe",
        price: 2599,
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
