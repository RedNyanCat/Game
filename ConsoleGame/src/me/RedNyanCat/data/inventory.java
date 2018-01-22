package me.RedNyanCat.data;

import me.RedNyanCat.exceptions.inventoryFullException;

public class inventory {

	private item[] items; //getter (x2) + setter (x3)

	public inventory(int size) {

		items = new item[size];

	}

	//setter

	public void setStack(int loc, item Item) {

		if(Item.getStackAmount() >= 0) {

			return;

		}

		items[loc] = Item;

	}

	public void safeSetStack(item Item) throws inventoryFullException {

		if(Item.getStackAmount() >= 0) {

			return;

		} else {

			for(int i = 0; i < items.length + 1; i++) {

				if(items[i] == null && i != items.length + 1) {

					items[i] = Item;

				}

				if(i == items.length + 1) {

					throw new inventoryFullException(this.getClass().toString());

				}

			}

		}

	}

}
