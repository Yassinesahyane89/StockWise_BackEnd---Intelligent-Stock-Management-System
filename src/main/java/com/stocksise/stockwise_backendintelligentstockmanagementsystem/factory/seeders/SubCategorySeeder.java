package com.stocksise.stockwise_backendintelligentstockmanagementsystem.factory.seeders;

import com.stocksise.stockwise_backendintelligentstockmanagementsystem.factory.fakers.SubCategoryFaker;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.models.entities.Category;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.repositories.CategoryRepository;
import com.stocksise.stockwise_backendintelligentstockmanagementsystem.repositories.SubCategoryRepository;
import org.springframework.stereotype.Component;

@Component
public class SubCategorySeeder {
    private final SubCategoryFaker subCategoryFaker;
    private final SubCategoryRepository subCategoryRepository;
    private final CategoryRepository categoryRepository;

    public SubCategorySeeder(SubCategoryFaker subCategoryFaker, SubCategoryRepository subCategoryRepository, CategoryRepository categoryRepository) {
        this.subCategoryFaker = subCategoryFaker;
        this.subCategoryRepository = subCategoryRepository;
        this.categoryRepository = categoryRepository;
    }

    public void run() {
        // create 10 sub-category for Laptop
        Category laptopCategory = categoryRepository.findByName("Laptops").orElse(null);
        if (laptopCategory != null) {
            subCategoryRepository.save(subCategoryFaker.create("Dell", "dell", "Dell Laptops", laptopCategory));
            subCategoryRepository.save(subCategoryFaker.create("HP", "hp", "HP Laptops", laptopCategory));
            subCategoryRepository.save(subCategoryFaker.create("Lenovo", "lenovo", "Lenovo Laptops", laptopCategory));
            subCategoryRepository.save(subCategoryFaker.create("Acer", "acer", "Acer Laptops", laptopCategory));
            subCategoryRepository.save(subCategoryFaker.create("Asus", "asus", "Asus Laptops", laptopCategory));
            subCategoryRepository.save(subCategoryFaker.create("Apple", "apple", "Apple Laptops", laptopCategory));
            subCategoryRepository.save(subCategoryFaker.create("Microsoft", "microsoft", "Microsoft Laptops", laptopCategory));
            subCategoryRepository.save(subCategoryFaker.create("Samsung", "samsung", "Samsung Laptops", laptopCategory));
            subCategoryRepository.save(subCategoryFaker.create("Toshiba", "toshiba", "Toshiba Laptops", laptopCategory));
            subCategoryRepository.save(subCategoryFaker.create("Sony", "sony", "Sony Laptops", laptopCategory));
        }
        // create 10 sub-category for Electronics
        Category electronicsCategory = categoryRepository.findByName("Electronics").orElse(null);
        if (electronicsCategory != null) {
            subCategoryRepository.save(subCategoryFaker.create("TV", "tv", "TV", electronicsCategory));
            subCategoryRepository.save(subCategoryFaker.create("Refrigerator", "refrigerator", "Refrigerator", electronicsCategory));
            subCategoryRepository.save(subCategoryFaker.create("Washing Machine", "washing-machine", "Washing Machine", electronicsCategory));
            subCategoryRepository.save(subCategoryFaker.create("Air Conditioner", "air-conditioner", "Air Conditioner", electronicsCategory));
            subCategoryRepository.save(subCategoryFaker.create("Microwave Oven", "microwave-oven", "Microwave Oven", electronicsCategory));
            subCategoryRepository.save(subCategoryFaker.create("Vacuum Cleaner", "vacuum-cleaner", "Vacuum Cleaner", electronicsCategory));
            subCategoryRepository.save(subCategoryFaker.create("Water Heater", "water-heater", "Water Heater", electronicsCategory));
            subCategoryRepository.save(subCategoryFaker.create("Iron", "iron", "Iron", electronicsCategory));
            subCategoryRepository.save(subCategoryFaker.create("Fan", "fan", "Fan", electronicsCategory));
            subCategoryRepository.save(subCategoryFaker.create("Air Cooler", "air-cooler", "Air Cooler", electronicsCategory));
        }

        // create 10 sub-category for Shoes
        Category shoesCategory = categoryRepository.findByName("Shoes").orElse(null);
        if (shoesCategory != null) {
            subCategoryRepository.save(subCategoryFaker.create("Sports Shoes", "sports-shoes", "Sports Shoes", shoesCategory));
            subCategoryRepository.save(subCategoryFaker.create("Casual Shoes", "casual-shoes", "Casual Shoes", shoesCategory));
            subCategoryRepository.save(subCategoryFaker.create("Formal Shoes", "formal-shoes", "Formal Shoes", shoesCategory));
            subCategoryRepository.save(subCategoryFaker.create("Sneakers", "sneakers", "Sneakers", shoesCategory));
            subCategoryRepository.save(subCategoryFaker.create("Boots", "boots", "Boots", shoesCategory));
            subCategoryRepository.save(subCategoryFaker.create("Slippers", "slippers", "Slippers", shoesCategory));
            subCategoryRepository.save(subCategoryFaker.create("Sandals", "sandals", "Sandals", shoesCategory));
            subCategoryRepository.save(subCategoryFaker.create("Flip Flops", "flip-flops", "Flip Flops", shoesCategory));
            subCategoryRepository.save(subCategoryFaker.create("Loafers", "loafers", "Loafers", shoesCategory));
            subCategoryRepository.save(subCategoryFaker.create("Heels", "heels", "Heels", shoesCategory));
        }

        // create 10 sub-category for Speakers
        Category speakersCategory = categoryRepository.findByName("Speakers").orElse(null);
        if (speakersCategory != null) {
            subCategoryRepository.save(subCategoryFaker.create("Bluetooth Speakers", "bluetooth-speakers", "Bluetooth Speakers", speakersCategory));
            subCategoryRepository.save(subCategoryFaker.create("Home Theaters", "home-theaters", "Home Theaters", speakersCategory));
            subCategoryRepository.save(subCategoryFaker.create("Soundbars", "soundbars", "Soundbars", speakersCategory));
            subCategoryRepository.save(subCategoryFaker.create("Portable Speakers", "portable-speakers", "Portable Speakers", speakersCategory));
            subCategoryRepository.save(subCategoryFaker.create("Computer Speakers", "computer-speakers", "Computer Speakers", speakersCategory));
            subCategoryRepository.save(subCategoryFaker.create("Bookshelf Speakers", "bookshelf-speakers", "Bookshelf Speakers", speakersCategory));
            subCategoryRepository.save(subCategoryFaker.create("Subwoofers", "subwoofers", "Subwoofers", speakersCategory));
            subCategoryRepository.save(subCategoryFaker.create("Smart Speakers", "smart-speakers", "Smart Speakers", speakersCategory));
            subCategoryRepository.save(subCategoryFaker.create("Soundbars", "soundbars", "Soundbars", speakersCategory));
            subCategoryRepository.save(subCategoryFaker.create("Soundbases", "soundbases", "Soundbases", speakersCategory));
        }

        // create 10 sub-category for Furniture
        Category furnitureCategory = categoryRepository.findByName("Furniture").orElse(null);
        if (furnitureCategory != null) {
            subCategoryRepository.save(subCategoryFaker.create("Sofa", "sofa", "Sofa", furnitureCategory));
            subCategoryRepository.save(subCategoryFaker.create("Bed", "bed", "Bed", furnitureCategory));
            subCategoryRepository.save(subCategoryFaker.create("Dining Table", "dining-table", "Dining Table", furnitureCategory));
            subCategoryRepository.save(subCategoryFaker.create("Wardrobe", "wardrobe", "Wardrobe", furnitureCategory));
            subCategoryRepository.save(subCategoryFaker.create("Dressing Table", "dressing-table", "Dressing Table", furnitureCategory));
            subCategoryRepository.save(subCategoryFaker.create("Study Table", "study-table", "Study Table", furnitureCategory));
            subCategoryRepository.save(subCategoryFaker.create("Shoe Rack", "shoe-rack", "Shoe Rack", furnitureCategory));
            subCategoryRepository.save(subCategoryFaker.create("Bookshelf", "bookshelf", "Bookshelf", furnitureCategory));
            subCategoryRepository.save(subCategoryFaker.create("TV Unit", "tv-unit", "TV Unit", furnitureCategory));
            subCategoryRepository.save(subCategoryFaker.create("Coffee Table", "coffee-table", "Coffee Table", furnitureCategory));
        }

        // create 10 sub-category for Bags
        Category bagsCategory = categoryRepository.findByName("Bags").orElse(null);
        if (bagsCategory != null) {
            subCategoryRepository.save(subCategoryFaker.create("Backpacks", "backpacks", "Backpacks", bagsCategory));
            subCategoryRepository.save(subCategoryFaker.create("Laptop Bags", "laptop-bags", "Laptop Bags", bagsCategory));
            subCategoryRepository.save(subCategoryFaker.create("Travel Bags", "travel-bags", "Travel Bags", bagsCategory));
            subCategoryRepository.save(subCategoryFaker.create("Duffle Bags", "duffle-bags", "Duffle Bags", bagsCategory));
            subCategoryRepository.save(subCategoryFaker.create("Trolley Bags", "trolley-bags", "Trolley Bags", bagsCategory));
            subCategoryRepository.save(subCategoryFaker.create("Handbags", "handbags", "Handbags", bagsCategory));
            subCategoryRepository.save(subCategoryFaker.create("Sling Bags", "sling-bags", "Sling Bags", bagsCategory));
            subCategoryRepository.save(subCategoryFaker.create("Messenger Bags", "messenger-bags", "Messenger Bags", bagsCategory));
            subCategoryRepository.save(subCategoryFaker.create("Clutches", "clutches", "Clutches", bagsCategory));
            subCategoryRepository.save(subCategoryFaker.create("Wallets", "wallets", "Wallets", bagsCategory));
        }

        // create 10 sub-category for Phones
        Category phonesCategory = categoryRepository.findByName("Phones").orElse(null);
        if (phonesCategory != null) {
            subCategoryRepository.save(subCategoryFaker.create("Smartphones", "smartphones", "Smartphones", phonesCategory));
            subCategoryRepository.save(subCategoryFaker.create("Feature Phones", "feature-phones", "Feature Phones", phonesCategory));
            subCategoryRepository.save(subCategoryFaker.create("Refurbished Phones", "refurbished-phones", "Refurbished Phones", phonesCategory));
            subCategoryRepository.save(subCategoryFaker.create("Tablets", "tablets", "Tablets", phonesCategory));
            subCategoryRepository.save(subCategoryFaker.create("Mobile Accessories", "mobile-accessories", "Mobile Accessories", phonesCategory));
            subCategoryRepository.save(subCategoryFaker.create("Landline Phones", "landline-phones", "Landline Phones", phonesCategory));
            subCategoryRepository.save(subCategoryFaker.create("Mobile Cases", "mobile-cases", "Mobile Cases", phonesCategory));
            subCategoryRepository.save(subCategoryFaker.create("Mobile Covers", "mobile-covers", "Mobile Covers", phonesCategory));
            subCategoryRepository.save(subCategoryFaker.create("Mobile Screen Guards", "mobile-screen-guards", "Mobile Screen Guards", phonesCategory));
            subCategoryRepository.save(subCategoryFaker.create("Mobile Chargers", "mobile-chargers", "Mobile Chargers", phonesCategory));
        }

        // create 10 sub-category for Accessories
        Category accessoriesCategory = categoryRepository.findByName("Accessories").orElse(null);
        if (accessoriesCategory != null) {
            subCategoryRepository.save(subCategoryFaker.create("Watches", "watches", "Watches", accessoriesCategory));
            subCategoryRepository.save(subCategoryFaker.create("Sunglasses", "sunglasses", "Sunglasses", accessoriesCategory));
            subCategoryRepository.save(subCategoryFaker.create("Jewellery", "jewellery", "Jewellery", accessoriesCategory));
            subCategoryRepository.save(subCategoryFaker.create("Belts", "belts", "Belts", accessoriesCategory));
            subCategoryRepository.save(subCategoryFaker.create("Wallets", "wallets", "Wallets", accessoriesCategory));
            subCategoryRepository.save(subCategoryFaker.create("Caps", "caps", "Caps", accessoriesCategory));
            subCategoryRepository.save(subCategoryFaker.create("Hats", "hats", "Hats", accessoriesCategory));
            subCategoryRepository.save(subCategoryFaker.create("Scarves", "scarves", "Scarves", accessoriesCategory));
            subCategoryRepository.save(subCategoryFaker.create("Gloves", "gloves", "Gloves", accessoriesCategory));
            subCategoryRepository.save(subCategoryFaker.create("Mufflers", "mufflers", "Mufflers", accessoriesCategory));
        }

        // create 10 sub-category for Chairs
        Category chairsCategory = categoryRepository.findByName("Chairs").orElse(null);
        if (chairsCategory != null) {
            subCategoryRepository.save(subCategoryFaker.create("Office Chairs", "office-chairs", "Office Chairs", chairsCategory));
            subCategoryRepository.save(subCategoryFaker.create("Study Chairs", "study-chairs", "Study Chairs", chairsCategory));
            subCategoryRepository.save(subCategoryFaker.create("Gaming Chairs", "gaming-chairs", "Gaming Chairs", chairsCategory));
            subCategoryRepository.save(subCategoryFaker.create("Recliners", "recliners", "Recliners", chairsCategory));
            subCategoryRepository.save(subCategoryFaker.create("Rocking Chairs", "rocking-chairs", "Rocking Chairs", chairsCategory));
            subCategoryRepository.save(subCategoryFaker.create("Accent Chairs", "accent-chairs", "Accent Chairs", chairsCategory));
            subCategoryRepository.save(subCategoryFaker.create("Lounge Chairs", "lounge-chairs", "Lounge Chairs", chairsCategory));
            subCategoryRepository.save(subCategoryFaker.create("Bean Bags", "bean-bags", "Bean Bags", chairsCategory));
            subCategoryRepository.save(subCategoryFaker.create("Folding Chairs", "folding-chairs", "Folding Chairs", chairsCategory));
            subCategoryRepository.save(subCategoryFaker.create("Metal Chairs", "metal-chairs", "Metal Chairs", chairsCategory));
        }

        // create 10 sub-category for Appliances
        Category appliancesCategory = categoryRepository.findByName("Appliances").orElse(null);
        if (appliancesCategory != null) {
            subCategoryRepository.save(subCategoryFaker.create("Water Purifiers", "water-purifiers", "Water Purifiers", appliancesCategory));
            subCategoryRepository.save(subCategoryFaker.create("Air Purifiers", "air-purifiers", "Air Purifiers", appliancesCategory));
            subCategoryRepository.save(subCategoryFaker.create("Water Heaters", "water-heaters", "Water Heaters", appliancesCategory));
            subCategoryRepository.save(subCategoryFaker.create("Irons", "irons", "Irons", appliancesCategory));
            subCategoryRepository.save(subCategoryFaker.create("Vacuum Cleaners", "vacuum-cleaners", "Vacuum Cleaners", appliancesCategory));
            subCategoryRepository.save(subCategoryFaker.create("Sewing Machines", "sewing-machines", "Sewing Machines", appliancesCategory));
            subCategoryRepository.save(subCategoryFaker.create("Air Coolers", "air-coolers", "Air Coolers", appliancesCategory));
            subCategoryRepository.save(subCategoryFaker.create("Fans", "fans", "Fans", appliancesCategory));
            subCategoryRepository.save(subCategoryFaker.create("Refrigerators", "refrigerators", "Refrigerators", appliancesCategory));
            subCategoryRepository.save(subCategoryFaker.create("Washing Machines", "washing-machines", "Washing Machines", appliancesCategory));
        }

        // create 10 sub-category for Clothing
        Category clothingCategory = categoryRepository.findByName("Clothing").orElse(null);
        if (clothingCategory != null) {
            subCategoryRepository.save(subCategoryFaker.create("T-Shirts", "t-shirts", "T-Shirts", clothingCategory));
            subCategoryRepository.save(subCategoryFaker.create("Shirts", "shirts", "Shirts", clothingCategory));
            subCategoryRepository.save(subCategoryFaker.create("Jeans", "jeans", "Jeans", clothingCategory));
            subCategoryRepository.save(subCategoryFaker.create("Trousers", "trousers", "Trousers", clothingCategory));
            subCategoryRepository.save(subCategoryFaker.create("Shorts", "shorts", "Shorts", clothingCategory));
            subCategoryRepository.save(subCategoryFaker.create("Sweatshirts", "sweatshirts", "Sweatshirts", clothingCategory));
            subCategoryRepository.save(subCategoryFaker.create("Jackets", "jackets", "Jackets", clothingCategory));
            subCategoryRepository.save(subCategoryFaker.create("Blazers", "blazers", "Blazers", clothingCategory));
            subCategoryRepository.save(subCategoryFaker.create("Suits", "suits", "Suits", clothingCategory));
        }

    }
}
