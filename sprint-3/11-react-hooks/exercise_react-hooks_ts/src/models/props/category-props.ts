interface CancelableProp
{
    onCancel: () => void
}

export interface CategoryAddProps extends CancelableProp
{
    onCategoryAdded: () => void
}