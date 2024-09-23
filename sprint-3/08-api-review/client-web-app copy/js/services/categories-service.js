class CategoryService
{
    baseUrl = `${config.baseUrl}/categories`;

    async getAllCategories2()
    {
        const response = await axios.get(this.baseUrl);

        return response.data;
    }

getAllCategories()
{
    return fetch(this.baseUrl).then(response => {
        if (!response.ok) {
            throw new Error(response.statusText);
        }
        response.json()
    });
}


    async getCategoryById(categoryId)
    {
        const response = await axios.get(`${this.baseUrl}/${categoryId}`);

        return response.data;
    }

    async addCategory(category)
    {
        const response = axios.post(this.baseUrl, category);

        return response.data;
    }

    async updateCategory(categoryId, category)
    {
        axios.put(`${this.baseUrl}/${categoryId}`, category);
    }

    async deleteCategory(categoryId)
    {
        axios.delete(`${this.baseUrl}/${categoryId}`);
    }
}