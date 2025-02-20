async function fetchProducts() {
	try {
		const response = await fetch('/api/v1/products'); // Call API
		const products = await response.json();

		const list = document.getElementById('product-list');
		list.innerHTML = '';

		products.forEach((product) => {
			const item = document.createElement('li');
			let propsText = Object.keys(product)
				.map((key) => `${key}: ${product[key]}`)
				.join(' - ');
			item.textContent = propsText;
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
