/*****************************************************************************************************
 * Lecture sample code.
 * Manage orders for a waiter/waitress (simple version).
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include <stdio.h>
#include <stdlib.h>

/* Enumerated types */
typedef enum {
	WATER,
	SOFT_DRINK,
	JUICE,
	BEER,
	COFFEE,
	TEA
} drink;

/* Structured types */
typedef struct orderItem {
	int table;
	drink drinkID;
	int quantity;
	struct orderItem *next;
} orderItem;

/* Function prototypes */
orderItem *newOrderItem(int, drink, int);
void printOrders(const orderItem *);
orderItem *freeOrderList(orderItem *);

/* Main function */
int main(void)
{
	/* List: Pointer to first element of list (NULL => empty) */
	orderItem *orders = NULL;

	/* Some orders */
	orderItem *order1 = newOrderItem(1, WATER, 2);
	orderItem *order2 = newOrderItem(1, SOFT_DRINK, 1);
	orderItem *order3 = newOrderItem(6, TEA, 2);

	/* Add the orders to the list */
	orders = order1;
	order1->next = order2;
	order2->next = order3;

	/* Print orders to the console */
	printOrders(orders);

	/* Free allocated memory */
	orders = freeOrderList(orders);

	getchar();
	return 0;
}

/* Print orders for a specific table (or all orders for table = 0) to the console */
void printOrders(const orderItem *orders)
{
	printf("Table | Order\n");
	printf("------+-----------------\n");
	if (orders != NULL)
	{
		do
		{
			printf("%5d | Drink #%d (%dx)\n", orders->table, orders->drinkID, orders->quantity);
		} while ((orders = orders->next) != NULL);
		putchar('\n');
	}
}

/* Allocate and initialize new structure of type orderItem */
orderItem *newOrderItem(int table, drink drinkID, int quantity)
{
	orderItem *newItem = (orderItem *)malloc(sizeof(orderItem));

	if (newItem != NULL)
	{
		newItem->table = table;
		newItem->drinkID = drinkID;
		newItem->quantity = quantity;
		newItem->next = NULL;
	}
	return newItem;
}

/* Empty list of orders */
orderItem *freeOrderList(orderItem *orders)
{
	orderItem *node = orders;

	while (node)
	{
		orderItem *freeNode = node;
		node = node->next;
		free(freeNode);
	}
	return NULL;
}
