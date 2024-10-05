/*****************************************************************************************************
 * Lecture sample code.
 * Manage orders for a waiter/waitress.
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
const char *drinkToString(const drink);
void printOrders(const orderItem *, int);
orderItem *addOrder(orderItem **, int, drink, int);
void removeOrders(orderItem **, int);
orderItem *freeOrderList(orderItem *);

/* Main function */
int main(void)
{
	orderItem *orders = NULL;

	/* Fill list with some orders */
	printf("Taking some orders ...\n");
	addOrder(&orders, 1, SOFT_DRINK, 2);
	addOrder(&orders, 1, WATER, 1);
	addOrder(&orders, 4, BEER, 4);
	addOrder(&orders, 6, TEA, 2);
	addOrder(&orders, 1, COFFEE, 1);
	printOrders(orders, 0);

	/* Print the orders for a specific table, only */
	printf("Printing orders for table 6, only ...\n");
	printOrders(orders, 6);

	/* Remove all orders for a specific table */
	printf("Removing orders for table 1 ...\n");
	removeOrders(&orders, 1);
	printOrders(orders, 0);

	/* Remove all orders in list */
	printf("Removing all orders ...\n");
	orders = freeOrderList(orders);
	printOrders(orders, 0);

	getchar();
	return 0;
}

/* Get corresponding string for enumerated drink constants */
const char *drinkToString(const drink id)
{
	switch (id)
	{
	case WATER:
		return "Water";
	case SOFT_DRINK:
		return "Soft drink";
	case JUICE:
		return "Juice";
	case BEER:
		return "Beer";
	case COFFEE:
		return "Coffee";
	case TEA:
		return "Tea";
	default:
		return "Unknown item";
	}
}

/* Print orders for a specific table (or all orders for table = 0) to the console */
void printOrders(const orderItem *orders, int table)
{
	printf("Table | Order\n");
	printf("------+-----------------\n");
	if (orders != NULL)
	{
		do
		{
			if ((table == 0) || (table == orders->table))
				printf("%5d | %-10s (%dx)\n", orders->table, drinkToString(orders->drinkID), orders->quantity);
		} while ((orders = orders->next) != NULL);
		putchar('\n');
	}
}

/* Add an order to a list of orders */
orderItem *addOrder(orderItem **listPtr, int table, drink menuID, int count)
{
	orderItem *listNode = *listPtr;
	orderItem *newNode;

	// Allocate and initialize new node
	if ((newNode = (orderItem *)malloc(sizeof(orderItem))) != NULL)
	{
		newNode->table = table;
		newNode->drinkID = menuID;
		newNode->quantity = count;
		newNode->next = NULL;
	}

	// Append node to end of list
	if (listNode)
	{
		while (listNode->next)
			listNode = listNode->next;
		listNode->next = newNode;
	}
	else
		*listPtr = newNode;

	return newNode;
}

/* Remove all orders for a specific table from a list of orders */
void removeOrders(orderItem **listPtr, int table)
{
	orderItem *prior, *node;

	// Remove matching nodes at beginning of list
	while (*listPtr && ((*listPtr)->table == table))
	{
		node = *listPtr;
		*listPtr = (*listPtr)->next;
		free(node);
	}
	prior = *listPtr;	// No matching table in this item

	// Run through rest of list
	while (prior && (node = prior->next))
	{
		// Remove item, if table matches
		if (node->table == table)
		{
			prior->next = node->next;
			free(node);
		}

		prior = prior->next;
	}
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
