async function fetchProducts() {
	try {
		const response = await fetch('/api/v1/products'); // Call API
		const products = await response.json();

		const list = document.getElementById('product-list');
		list.innerHTML = '';

		products.forEach((productWithQuantity) => {
			const item = document.createElement('li');
			item.textContent = `${productWithQuantity.product.name} - ${productWithQuantity.product.description} - ${productWithQuantity.product.dateOfManufacture} - $${productWithQuantity.product.price} - ${productWithQuantity.quantity}`;
			list.appendChild(item);
		});
	} catch (error) {
		console.error('Error fetching products:', error);
	}
}

// Fetch products when page loads
document.addEventListener('DOMContentLoaded', () => {
	fetchProducts();
	setInterval(fetchProducts, 10000);
});
