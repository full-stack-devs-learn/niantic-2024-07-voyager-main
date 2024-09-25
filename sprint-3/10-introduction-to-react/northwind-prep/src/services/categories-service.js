import config from "../config.js";
import axios from "axios";

class CategoriesService {
    baseUrl = config.baseUrl;

    async getCategories() {
        const response = await axios.get(`${this.baseUrl}/categories`)
        return response.data
    }

    async add(category)
    {
        const response = await axios.post(`${this.baseUrl}/categories`, category);
        return response.data
    }

    async delete(id)
    {
        await axios.delete(`${this.baseUrl}/categories/${id}`);
    }

}
const categoriesService = new CategoriesService();
export default categoriesService;