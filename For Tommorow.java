	boolean fromFile = false; 
 try {
                fromFile = model.loadFromFile();
            }catch (IOException e) {
                System.out.println("File Not Found");
            }
            if (!fromFile) {
                model.populateHouses();
                model.populateCustomers();
            }
			
	//Model		
	public void saveFromFile() throws IOException
    {
        File file = new File(saveLoad.toString());
        FileOutputStream fos = new  FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        Customer[] theCustomers = customers.toArray(new Customer[customers.size()]);
//        ArrayList<House> theHouses = new ArrayList<>();
//        for(int i = 1; i < houseMap.size(); i++)
//        {
//            theHouses.add(houseMap.get(i));
//        }
//        House[] houses = theHouses.toArray(new House[theHouses.size()]);
        oos.writeObject(theCustomers);
//        oos.writeObject(houses);
        oos.close();
    }

    public boolean loadFromFile() throws IOException
    {
        File file = new File(saveLoad.toString());
        if (file.exists() && !file.isDirectory()){
            try {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                Customer[] customer = (Customer[]) ois.readObject();

                customers.addAll(Arrays.asList(customer));
            ois.close();
            return true;
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }
        }
        return false;
    }