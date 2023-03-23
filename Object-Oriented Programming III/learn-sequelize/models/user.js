const Sequelize = require('sequelize');

class User extends Sequelize.Model{
    static initiate(sequelize) {
        User.init({
            name: {
                type: Sequelize.STRING(20),
                allowNull: false,
                unique: false,
            },
            age: {
                type: Sequelize.INTEGER.UNSIGNED,
                allowNull: false,
            },
            merried: {
                type: Sequelize.BOOLEAN,
                allowNull: true,
            },
            comment: {
                type: Sequelize.TEXT,
                allowNull: true,
            },
            created_at: {
                type: Sequelize.DATE,
                allowNull: false,
                defaultValue: Sequelize.NOW,
            },            
        }, {
            sequelize,
            timestamps: false,
            modelName: 'User',
            tableName: 'users',
            paranoid: false,
            underscored: false,
            charset: 'utf8mb4',
            collate: 'utf8mb4_general_ci'
        });
    }
    static associate(db){

    }
};

module.exports = User;