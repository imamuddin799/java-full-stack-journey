import React, { Component } from "react";
import { Fragment } from "react";

class ShoppingCart extends Component {
    constructor(props) {
        super(props);
        this.state = {
            items: [],
            totalPrice: 0,
        };
    }

    addItem = (item) => {
        this.setState((prevState) => ({
            items: [...prevState.items, item],
            totalPrice: prevState.totalPrice + item.price,
        }));
    };
    removeItem = (index) => {
        this.setState((prevState) => {
            const updatedItems = [...prevState.items];
            const removedItem = updatedItems.splice(index, 1)[0];

            return {
                items: updatedItems,
                totalPrice: prevState.totalPrice - removedItem.price,
            };
        });
    };

    listOfItems = [
        {
            name: "Laptop",
            price: 800
        },
        {
            name: "Mobile",
            price: 80
        },
        {
            name: "Bag",
            price: 30
        }
    ]

    render() {
        return (
            <div>
                <h2>Shopping Cart</h2>
                <ul>
                    {this.state.items.map((item, index) => (
                        <li key={index}>
                            {item.name} - ${item.price}
                            <button onClick={() => this.removeItem(index)}>Remove</button>
                        </li>
                    ))}
                </ul>
                <h3>Total Price: ${this.state.totalPrice}</h3>

                {
                    this.listOfItems.map((element, index) => {
                        let { name, price } = element;
                        return <Fragment key={index}>
                            <button onClick={() => this.addItem({ name, price })}>
                                Add { name } (${price})
                            </button>
                        </Fragment>
                    })
                }
            </div>
        );
    }
}

export default ShoppingCart;